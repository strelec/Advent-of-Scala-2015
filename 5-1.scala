val vowels = "aeiou".toSet
val forbidden = Set("ab", "cd", "pq", "xy")
def duplicate(ss: String) = ss(0) == ss(1)

println((for {
	s <- io.Source.stdin.getLines
	if  s.count(vowels) >= 3
	if  s.sliding(2).exists(duplicate)
	if !s.sliding(2).exists(forbidden)
} yield true).size)
