# class Box
#    def initialize(w,h)
#       @width, @height = w, h
#    end

#    def getWidth
#       @width
#    end
#    def getHeight
#       @height
#    end

#    def setWidth=(value)
#       @width = value
#    end
#    def setHeight=(value)
#       @height = value
#    end
# end

# # create an object
# box = Box.new(10, 20)

# # use setter methods
# box.setWidth = 30
# box.setHeight = 50

# # use accessor methods
# x = box.getWidth()
# y = box.getHeight()

# puts "Width of the box is : #{x}"
# puts "Height of the box is : #{y}"

class Person
  # attr_accessor :name
  attr_writer :name
  attr_reader :name
end

person = Person.new
person.name = "Dennis"
puts person.name