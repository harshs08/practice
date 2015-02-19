# you can use puts for debugging purposes, e.g.
# puts "this is a debug message"


def solution(a, b)
    # write your code in Ruby 1.9.3
    a = 0 if a < 0
    return 0 if b<0
    return Math.sqrt(b).floor - Math.sqrt(a).ceil + 1
end
