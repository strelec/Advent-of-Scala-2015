val lengths = Vector(2, 32, 27, 42, 34, 28, 24, 18, 14, 12, 9, 10, 10, 7, 12, 10, 6, 4, 4, 2, 16, 14, 8, 5, 12, 8, 5, 8, 6, 3, 17, 23, 26, 20, 16, 14, 10, 7, 7, 23, 28, 20, 15, 21, 24, 18, 12, 10, 8, 5, 7, 13, 18, 14, 8, 6, 5, 10, 8, 6, 3, 6, 7, 11, 16, 12, 7, 9, 14, 10, 6, 5, 32, 27, 42, 34, 28, 24, 18, 14, 12, 9, 10, 10, 7, 12, 10, 6, 4, 4, 2, 1)

val transitions = Vector(Seq(0), Seq(71, 90, 0, 19, 2), Seq(1), Seq(31, 19, 2), Seq(3), Seq(4), Seq(5), Seq(6), Seq(7), Seq(8), Seq(9), Seq(60, 10), Seq(11), Seq(12), Seq(66, 13), Seq(14), Seq(15), Seq(16), Seq(17), Seq(18), Seq(66, 90, 0, 19, 26), Seq(20), Seq(21), Seq(22), Seq(23, 13), Seq(24), Seq(25), Seq(29, 26), Seq(27), Seq(28), Seq(62, 19, 88, 0, 19, 29), Seq(66, 30), Seq(31, 10), Seq(32), Seq(33), Seq(34), Seq(35), Seq(36), Seq(37, 91), Seq(38, 0, 19, 42), Seq(67, 39), Seq(40), Seq(41), Seq(62, 19, 42), Seq(66, 43), Seq(44), Seq(45), Seq(46), Seq(47), Seq(48), Seq(60, 49), Seq(62, 19, 50), Seq(66, 51), Seq(52), Seq(53), Seq(54), Seq(55), Seq(56, 0, 19, 26), Seq(57), Seq(58), Seq(59), Seq(60, 19, 29), Seq(61), Seq(62, 19, 26), Seq(66, 63), Seq(64), Seq(65), Seq(66, 60), Seq(67, 19, 26), Seq(68), Seq(69), Seq(70), Seq(71, 90, 0, 19, 73), Seq(72), Seq(31, 19, 73), Seq(74), Seq(75), Seq(76), Seq(77), Seq(78), Seq(79), Seq(80), Seq(60, 81), Seq(82), Seq(83), Seq(66, 84), Seq(85), Seq(86), Seq(87), Seq(88), Seq(89), Seq(90))

val size = lengths.size

var state = Array.fill(size)(0)
state(86) = 1

(1 to 50).foreach { _ =>
	val newstate = Array.fill(size)(0)
	for {
		element <- 0 until size
		count = state(element)
		product <- transitions(element)
	} newstate(product) += count
	state = newstate
}

println((state, lengths).zipped.map(_ * _).sum)
