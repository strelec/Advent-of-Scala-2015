var line = io.StdIn.readLine

val regex = raw"(\d)\1*".r
(1 to 40).foreach { i =>
	line = regex.replaceAllIn(line, m =>
		m.matched.size + m.matched.take(1)
	)
}

println(line.size)
