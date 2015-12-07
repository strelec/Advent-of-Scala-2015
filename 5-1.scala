val vowels = "aeiou".toSet
val forbidden = Set("ab", "cd", "pq", "xy")
def duplicate(s: String) = s(0) == s(1)

val result = for {
	s <- io.Source.stdin.getLines
	if  s.count(vowels) >= 3
	if  s.sliding(2).exists(duplicate)
	if !s.sliding(2).exists(forbidden)
} yield true

println(result.count(identity))
