def find_leader(ar)
	n = ar.length
	size = 0
	value = 0

	ar.each do |elem|
		if size == 0
			size += 1
			value = elem
		else
			if value == elem
				size += 1
			else
				size -= 1
			end
		end
	end
	candidate = -1
	leader = -1
	count = 0
	candidate = value if size > 0 

	ar.each do |e|
		if e == candidate
			count += 1
		end
	end

	leader = candidate if count > n/2 

	return leader

end

array = [6,8,4,6,8,6,3]
puts find_leader(array)