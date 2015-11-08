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

    ; For non-GUI's, allows the user to close the app by pressing ESC
    HotKeySet("{ESC}", "_Terminate")

    ; Forces the coder to declare all variables before they can be used
        ; 0 = Must declare, 1 = You don't have too
    Opt("MustDeclareVars", 0)

    ; Option to hide or show the autoit icon in the taskbar
        ; 0 = Show, 1 = Hide, Or use #NoTrayIcon
    ;Opt("TrayIconHide", 1)
    #NoTrayIcon

    ; Option that allows WinActivate partial searches
    Opt("WinTitleMatchMode", 2)

    ; Requires that the script be ran as an administrator
    #RequireAdmin

; // Compiling option ----------------------------------------------------------------------
    ; Require that the script be compiled to run it
    ;   _CompiledCheck()
    ; What the program should be called when it's compiled
        #pragma compile(Out, HideDriveLetter.exe)
    ; Compiles on a 64-bit OS
        #pragma compile(x64, True)
    ; The description of the program
        #pragma compile(FileDescription, Hide Drive Letters From Windows Explorer)
    ; Name of the program
        #pragma compile(ProductName, HideDriveLetter)
    ; Product Version
        #pragma compile(ProductVersion, 0.1)
    ; File Version
        #pragma compile(FileVersion, 0.0.0.1)
    ; Company name
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
    FileWrite($registryFile, "[HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer]")
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