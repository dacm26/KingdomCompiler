.data
	_msg0:	.asciiz "\n\n"
	_msg1:	.asciiz "\n\n"
	_msg2:	.asciiz "\n\n"
	_msg3:	.asciiz "\n\n"
	_msg4:	.asciiz "Popeye\n"
	_msg5:	.asciiz "\n\n"
	_x:	.word	0
	_a:	.byte	'0'
	_b:	.byte	0
	_c:	.double	0.0
	_d:	.space	255
	_double0:	.double 3.1415
	_char0:	.byte 'a'
	_bool0:	.byte 0
	_int0:	.word 16
	_zeroDouble:	.double	0.0	
	_charBuffer:	.space	2	
.text
	main:
		lw $t0, _int0
		sw $t0, _x
		li $v0, 4
		la $a0, _msg0
		syscall
		li $v0, 1
		lw $a0, _x
		syscall
		lb $t0, _char0
		sb $t0, _a
		li $v0, 4
		la $a0, _msg1
		syscall
		li $v0, 4
		la $a0, _a
		syscall
		lb $t0, _bool0
		sb $t0, _b
		li $v0, 4
		la $a0, _msg2
		syscall
		li $v0, 1
		lb $a0, _b
		syscall
		l.d $f0, _double0
		s.d $f0, _c
		li $v0, 4
		la $a0, _msg3
		syscall
		li $v0, 3
		l.d $f12, _c
		syscall
		la $a0, _msg4
		la $a1, _d
		jal _string_copy
		li $v0, 4
		la $a0, _msg5
		syscall
		li $v0, 4
		la $a0, _d
		syscall
		li $v0, 10
		syscall

	_string_copy:
		lb $s0, ($a0)
		beqz $s0, _string_copy_end
		b _string_copy_char

		_string_copy_char:
		sb $s0, ($a1)
		addi $a0, $a0, 1
		addi $a1, $a1, 1
		b _string_copy

	_string_copy_end:
		sb $zero, ($a1)
		jr $ra
