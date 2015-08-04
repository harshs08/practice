class SelectionSort	
	def sort(values)
		i = 0
		while i < values.length - 1
			minIdx = i
			j = i+1
			while j < values.length
				if values[j] < values[minIdx]
					minIdx = j
				end
				j = j+1
			end
			temp = values[i]
			values[i] = values[minIdx]
			values[minIdx] = temp
			i = i+1	
		end
		puts values
	end
end

ss = SelectionSort.new
arr = [7,4,1,2]
ss.sort(arr)

# [7,4,1,2]
# 