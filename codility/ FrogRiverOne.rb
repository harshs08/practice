#https://codility.com/demo/results/demoE4AB9Q-Z2Q/
# you can use puts for debugging purposes, e.g.
# puts "this is a debug message"

def solution(x, a)
    # write your code in Ruby 1.9.3
    count = Array.new(x) {0}
    sum = 0

    a.each_with_index do |e,i|   
        if count[e-1] == 0
            count[e-1] = 1
            sum += 1
        end
        return i if sum == x
    end
    return -1     
end