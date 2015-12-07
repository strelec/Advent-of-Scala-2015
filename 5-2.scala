def around(s: String) = s(0) == s(2)

val result = for {
	s <- io.Source.stdin.getLines
	if s.sliding(2).exists( ss =>
		s.lastIndexOf(ss) - s.indexOf(ss) > 1
	)
	if s.sliding(3).exists(around)
} yield true

println(result.count(identity))
