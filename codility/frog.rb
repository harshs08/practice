# you can use puts for debugging purposes, e.g.
# puts "this is a debug message"

def solution(a, x, d)
    # write your code in Ruby 1.9.3
    b = Array.new(x,0)
    start = 0
    
    a.each_with_index do |e, i|
        b[e] = 1
        j = start + d
        while j>start do
            j = j - 1
            if b[j] == 1
                start = j
                if (x -start) <= d
                    return i
                end
            end
        end
    end

    return -1
end

