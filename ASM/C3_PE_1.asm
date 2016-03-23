; #################################################################################
; Name: Billy Hart
; Chapter: 3
; Assignment: Programming Exercises
; Date: 03/09/16
; Description: This program subtracts three named integer values using only 16-bit
;              registers.
; #################################################################################

; *_____- * - Grade - * -_____
; |                           |
; |                           |
; |                           |
; |                           |
; |                           |
; |___________________________|

TITLE Subtract Three Integers		(SubThreeInts.asm)

INCLUDE Irvine32.inc

.data ;----------------------------------------------------------------------------
three		WORD	64
named		WORD	32
integers	WORD	16

.code ;----------------------------------------------------------------------------
main proc

	mov		ax, 80h			; AX = 80h
	call	DumpRegs
	sub		ax, three		; AX = 40h
	call	DumpRegs
	sub		ax, named		; AX = 20h
    call	DumpRegs
	sub		ax, integers	; AX = 10h
	call	DumpRegs
    exit

main endp
end main