val regex = raw"(\\+)(x[^\\]{2}|.)".r

println(io.Source.stdin.getLines.map { line =>
	regex.findAllMatchIn(line).map { m =>
		val backslashes = m.group(1).size
		val evenNumber = backslashes % 2 == 0
		backslashes/2 + (if (evenNumber) 0 else m.group(2).size)
	}.sum + 2
}.sum)
