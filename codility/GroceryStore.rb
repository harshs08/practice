def groceryStore(arr)
	sum = 0
	result = 0
	arr.each do |e|
		if e == 0
			sum += 1 
		else
			sum -= 1
			result = [result, -sum].max
		end
	end
	return result
end

A = [0,1,1,1]
B = [1, 1, 0, 0, 0, 0, 1, 1, 1]
puts groceryStore(B)