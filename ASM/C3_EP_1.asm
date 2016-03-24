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

TITLE Subtract Three Integers

INCLUDE Irvine32.inc

.data ;----------------------------------------------------------------------------
three		WORD	64
named		WORD	32
integers	WORD	16
TAX_RATE = 0.0975

.code ;----------------------------------------------------------------------------
main proc

	mov	ax, 80h		; AX = 80h
	call	DumpRegs
	sub	ax, three	; AX = 40h
	call	DumpRegs
	sub	ax, named	; AX = 20h
    	call	DumpRegs
	sub	ax, integers	; AX = 10h
	call	DumpRegs
    	exit

main endp
end main

; results -------------------------------------------------------------------------
  EAX=07F80080  EBX=0026F000  ECX=00401055  EDX=00401055
  ESI=00401055  EDI=00401055  EBP=0019FF94  ESP=0019FF84
  EIP=004035F9  EFL=00000246  CF=0  SF=0  ZF=1  OF=0  AF=0  PF=1


  EAX=07F80040  EBX=0026F000  ECX=00401055  EDX=00401055
  ESI=00401055  EDI=00401055  EBP=0019FF94  ESP=0019FF84
  EIP=00403605  EFL=00000202  CF=0  SF=0  ZF=0  OF=0  AF=0  PF=0


  EAX=07F80020  EBX=0026F000  ECX=00401055  EDX=00401055
  ESI=00401055  EDI=00401055  EBP=0019FF94  ESP=0019FF84
  EIP=00403611  EFL=00000202  CF=0  SF=0  ZF=0  OF=0  AF=0  PF=0


  EAX=07F80010  EBX=0026F000  ECX=00401055  EDX=00401055
  ESI=00401055  EDI=00401055  EBP=0019FF94  ESP=0019FF84
  EIP=0040361D  EFL=00000202  CF=0  SF=0  ZF=0  OF=0  AF=0  PF=0