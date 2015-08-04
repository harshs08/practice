class BubbleSort
  def sort(values)
    not_swapped = true
    i = 0
    while i < values.length
      j = 0
      while j < values.length-1-i
        if values[j+1] < values[j]
          temp        = values[j+1]
          values[j+1] = values[j]
          values[j]   = temp
          not_swapped = false
        end
        j = j+1
      end
      i = i+1
      exit if not_swapped
    end
    puts values
  end
end

bs = BubbleSort.new
arr = [3,5,1,2,4]
bs.sort(arr)
