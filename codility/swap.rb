def solution(a)
  # write your code in Ruby 1.9.3
  n = a.length - 1
  lmark = 0
  rmark = 0
  (0...n).each do |i|
    if a[i] > a[i+1]
      lmark = i
    end
  end
  (0...n).each do |i|
    if a[n-i] < a[n-i-1]
      rmark = n-i
    end
  end

  temp = a[lmark]
  a[lmark] = a[rmark]
  a[rmark] = temp

  (0...n).each do |i|
    return false if a[i] > a[i+1]
  end

  return true

end