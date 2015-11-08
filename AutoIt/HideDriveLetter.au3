; # INFO # ===============================================================================================
; Title ..........: HideDriveLetter
; Version.........: 0.01
; Description ....: Hides a given drive letter from windows explorer
; Author(s) ......: Wolfeh
; AutoIt Version..: 3.3.12.0
; Notes...........:
; ======================================================================================================

#Region ## TO DO ## ------------------------------------------------------------------------

    ; Option: Hide all drives
    ; Option: Unhide all drives
    ; Option: Hide multiple drives
    ; Option: Let user decide wether or not to delete the registry file

#EndRegion ---------------------------------------------------------------------------------

#Region ## CHANGELOG ## --------------------------------------------------------------------

; Version 0.01
; Uses input box for drive letter, hides it, and resets shell.

#EndRegion ---------------------------------------------------------------------------------

#Region ## SETTINGS ## ---------------------------------------------------------------------

    HotKeySet("{ESC}", "_Terminate")
    Opt("MustDeclareVars", 0)
    #NoTrayIcon
    Opt("WinTitleMatchMode", 2)
    #RequireAdmin

; // Compiling options ----------------------------------------------------------------------
        #pragma compile(Out, HideDriveLetter.exe)
        #pragma compile(x64, True)
        #pragma compile(FileDescription, Hide Drive Letters From Windows Explorer)
        #pragma compile(ProductName, HideDriveLetter)
        #pragma compile(ProductVersion, 0.1)
        #pragma compile(FileVersion, 0.0.0.1)
        #pragma compile(CompanyName, '+W+')

#EndRegion ---------------------------------------------------------------------------------

#Region ## INCLUDES ## ---------------------------------------------------------------------

#include <Array.au3>
#include <FileConstants.au3>
#include <MsgBoxConstants.au3>

#EndRegion ---------------------------------------------------------------------------------


#Region ## MAIN ## ---------------------------------------------------------------------

$driveLetter = _DriveLetterToHide()
_HideDriveLetter($driveLetter)

#EndRegion ---------------------------------------------------------------------------------


#Region ## FUNCTIONS  ## ---------------------------------------------------------------------

Func _DriveLetterToHide()
    $driveLetter = InputBox("Hide A Drive", "Drive letter to hide:", "D")
    ConsoleWrite("Drive Letter Selected: " & $driveLetter & @CRLF)

    Local $driveLetterArray[26]
    For $loopCounter = Asc("A") To Asc("Z") Step +1
        $driveLetterArray[$loopCounter - Asc("A")] = Chr($loopCounter)
    Next
    ;_ArrayDisplay($driveLetterArray)

    Local $driveLetterAsIndex = _ArrayBinarySearch($driveLetterArray, $driveLetter)
    If @error Then
        MsgBox($MB_SYSTEMMODAL, "Drive letter not found", "Drive Letter Not Found" & @CRLF & "Error: " & @error)
    EndIf
    ConsoleWrite("Drive Letter Index: " & $driveLetterAsIndex & @CRLF)
    
    Local $driveLetterAsRegistryValue = (2^$driveLetterAsIndex)
    ConsoleWrite("Drive Letter Registry Value: " & $driveLetterAsRegistryValue & @CRLF)

    Return $driveLetterAsRegistryValue
EndFunc


Func _HideDriveLetter($driveLetter)

    Local Const $registryFilePath = @DesktopDir & "\HideDrive.reg"
    Local Const $registryHeader = "Windows Registry Editor Version 5.00"
    Local Const $registryPath = "[HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer]"
    Local $driveLetterInHex = Hex(StringFormat("%08d", $driveLetter))

    If Not FileWrite($registryFilePath, $registryHeader & @CRLF) Then
        MsgBox($MB_SYSTEMMODAL, "Hide Drive", "An error occurred when writing the registry file.")
        Exit
    EndIf
    ConsoleWrite("Created Registry File" & @CRLF)

    Local Const $APPEND_TO_END_OF_FILE = 1
    Local $registryFile = FileOpen($registryFilePath, $APPEND_TO_END_OF_FILE)
    If $registryFile = -1 Then
        MsgBox($MB_SYSTEMMODAL, "", "An error occurred when opening the registry file for editing.")
        Return False
    EndIf
    ConsoleWrite("Opened Registry File For Editing" & @CRLF)

    FileWrite($registryFile, @CRLF)
    FileWrite($registryFile, $registryPath)
    FileWrite($registryFile, @CRLF)
    FileWrite($registryFile, '"NoDrives"=dword:' & $driveLetterInHex)
    FileWrite($registryFile, @CRLF)
    ConsoleWrite("Added Keys To Hide Drive" & @CRLF)

    FileClose($registryFile)
    ConsoleWrite("Closed The File" & @CRLF)

    ShellExecute($registryFilePath)
    ConsoleWrite("Executing Registry File" & @CRLF)

    Local $registryDialogName = "Registry Editor"
    WinWaitActive($registryDialogName, "", 10)
    If WinActive($registryDialogName) Then
        ControlSend($registryDialogName, "", "Button1", "!Y")
        ConsoleWrite("Closed The Registry Warning" & @CRLF)
    Else
        MsgBox($MB_SYSTEMMODAL, $registryDialogName, "Registry Warning Failed To Open")
    EndIf

    WinWaitActive($registryDialogName, "", 10)
    If WinActive($registryDialogName) Then
        ControlSend($registryDialogName, "", "Button1", "{ENTER}")
        ConsoleWrite("Closed Registry Success" & @CRLF)
    Else
        MsgBox($MB_SYSTEMMODAL, $registryDialogName, "Registry Success Notice Did Not Populate")
    EndIf

   FileDelete($registryFilePath)
   ConsoleWrite("Deleted Registry File" & @CRLF)

   ; Resets the explorer shell to avoid reboot for affects to apply
   ProcessClose("explorer.exe")
   ConsoleWrite("Closed Explorer" & @CRLF)
   Sleep(1000)
   ShellExecute("explorer.exe")
   ConsoleWrite("Restarted Explorer" & @CRLF)
EndFunc

#EndRegion ---------------------------------------------------------------------------------