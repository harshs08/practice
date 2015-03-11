#dp fib
def fib(n)
	fibs = Array.new(n+1)
	fibs[0] = 0
	fibs[1] = 1
	i = 2
	while(i < n)
		fibs[i] = fibs[i-1] + fibs[i-2];
		i += 1
	end
	return fibs
end

puts fib(4)
