def solution(a)
    # write your code in Ruby 1.9.3
    n = a.length
    flag = 0
    i = 0
    while(i< n-2)
        if (a[i] == 0 && a[i+1] == 1 && a[i+2] == 0)
            #puts i
            a[i+1] = 0
            flag = 1
            break
        end
        if a[i] == 1 && a[i+1] == 0 && a[i+2] == 1 
            a[i+1] = 1
            flag = 1
            break
        end
        i += 1
    end
    
    if flag != 1
        if a[0] != a[1]
            a[0] = a[1]
        elsif a[n-1] != a[n-2]
            a[n-1] = a[n-2]
        end      
    end
    
    count = 0
    i = 0
    while(i<n-1)
       if(a[i]==a[i+1])
           count += 1
        end
        i+= 1
    end
    return count
end

puts solution([1,0,0,0])