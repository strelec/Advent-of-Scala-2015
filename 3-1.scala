println(io.StdIn.readLine.scanLeft(0 -> 0) {
	case ((x,y), '>') => (x+1, y)
	case ((x,y), '<') => (x-1, y)
	case ((x,y), '^') => (x, y+1)
	case ((x,y), 'v') => (x, y-1)
}.distinct.size)
