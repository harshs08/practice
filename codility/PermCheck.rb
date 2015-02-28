# you can use puts for debugging purposes, e.g.
# puts "this is a debug message"

def solution(a)
    # write your code in Ruby 1.9.3
    count = Array.new(a.length,0)
    a.each do |e|
        return 0 if e > a.length
        count[e-1] += 1       
    end
    
    (1..count.length-1).each do |i|
        return 0 if count[i]!=1 || count[i] > 1
    end
    
    return 1
end