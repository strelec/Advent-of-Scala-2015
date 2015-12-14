println(io.StdIn.readLine.grouped(2).scanLeft( Seq(0 -> 0, 0 -> 0) )(
	(a, b) => (a,b).zipped.map {
		case ((x,y), '>') => (x+1, y)
		case ((x,y), '<') => (x-1, y)
		case ((x,y), '^') => (x, y+1)
		case ((x,y), 'v') => (x, y-1)
	}
).flatten.toSeq.distinct.size)
