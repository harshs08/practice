#palin

def solution(s)
   
    freq_bin = Array.new(26,0)
    
    s.each_byte do |ele|
        freq_bin[ele-97]+= 1
    end
    p freq_bin
    odd = 0
    freq_bin.each do |e|
      odd += 1 if e%2 != 0 
       return 0 if odd > 1
    end
    return 1
    
end

puts solution("aabaa")
