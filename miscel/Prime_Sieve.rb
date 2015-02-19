def sieve(n)
	i = 2
	sieve = Array.new (n) { true }
	sieve[0] = sieve[1] = false
	for (i*i) in i..n
		puts i
		k = i*i
		if sieve[k]
			while k<=n	
				sieve[k] = false
				k += i
			end		 		
		end
	end
	return sieve
end

p sieve(10)