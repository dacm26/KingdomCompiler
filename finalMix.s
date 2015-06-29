.data
	_msg0:	.asciiz "Hola Mundo!\n"
	_msg1:	.asciiz "Ingrese int: \n"
	_msg2:	.asciiz "Ingrese bool: \n"
	_msg3:	.asciiz "Ingrese char: \n"
	_msg4:	.asciiz "Ingrese munny: \n"
	_msg5:	.asciiz "Ingrese KChain: \n"
	_msg6:	.asciiz "Soy un int: \n"
	_msg7:	.asciiz "Soy un bool: \n"
	_msg8:	.asciiz "Soy un char: \n"
	_msg9:	.asciiz "Soy un double: \n"
	_msg10:	.asciiz "Soy un e: \n"
	_a:	.word	0
	_b:	.byte	0
	_c:	.space	1
	_d:	.double	0.0
	_e:	.space	255
	_zeroDouble:	.double	0.0	
	_charBuffer:	.space	2	
.text
	main:
		li $v0, 4
		la $a0, _msg0
		syscall
		li $v0, 4
		la $a0, _msg1
		syscall
		li $v0, 5
		syscall
		sw $v0, _a
		li $v0, 4
		la $a0, _msg3
		syscall
		li $v0, 8
		la $a0, _charBuffer
		la $a1, 2
		syscall
		lb $s0,($a0)
		sb $s0, _c
		li $v0, 4
		la $a0, _msg4
		syscall
		li $v0, 7
		syscall
		s.d $f0, _d
		li $v0, 4
		la $a0, _msg5
		syscall
		li $v0, 8
		la $a0, _e
		la $a1, 255
		syscall
		li $v0, 4
		la $a0, _msg6
		syscall
		li $v0, 1
		lw $a0, _a
		syscall
		li $v0, 4
		la $a0, _msg7
		syscall
		li $v0, 1
		lb $a0, _b
		syscall
		li $v0, 4
		la $a0, _msg8
		syscall
		li $v0, 4
		la $a0, _c
		syscall
		li $v0, 4
		la $a0, _msg9
		syscall
		li $v0, 3
		l.d $f12, _d
		syscall
		li $v0, 4
		la $a0, _msg10
		syscall
		li $v0, 4
		la $a0, _e
		syscall
		li $v0, 10
		syscall
