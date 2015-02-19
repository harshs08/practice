#sib
def solution(n)
    # write your code in Ruby 1.9.3
    a = Array.new(10,0)
    res = 0
    pow = 0
    
    while(n>0)
        a[n%10] +=1
        n /= 10
    end
    i = 0
    while(i<10)
       num = a[i]
       if num != 0
            while(num > 0) 
                res += i*10**pow
                pow += 1
                num-= 1
            end
        end
        i+= 1
    end
    return -1 if res > 100000000
    return res
end