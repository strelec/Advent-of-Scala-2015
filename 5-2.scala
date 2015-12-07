def around(ss: String) = ss(0) == ss(2)

println((for {
	s <- io.Source.stdin.getLines
	if s.sliding(2).exists( ss =>
		s.lastIndexOf(ss) - s.indexOf(ss) > 1
	)
	if s.sliding(3).exists(around)
} yield true).size)
