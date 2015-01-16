# Definition for a point
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution:
    # @param points, a list of Points
    # @return an integer
    def maxPoints(self, points):
        result = 0
        for i in xrange(len(points)):
            d = {}
            duplicate = 0
            for j in xrange(len(points)):
                if i == j:
                    d["me"] = 1
                    continue
                deltax = points[i].x - points[j].x
                deltay = points[i].y - points[j].y
                if deltax == 0:
                    if deltay == 0:
                        duplicate += 1
                    else:
                        if "inf" not in d:
                            d["inf"] = 1
                        else:
                            d["inf"] += 1
                else:
                    deltay = points[i].y - points[j].y
                    slope = float(deltay) / float(deltax)
                    if slope not in d:
                        d[slope] = 1
                    else:
                        d[slope] += 1
            for key in d:
                # the point it self
                if key != "me":
                    d[key] += 1
                d[key] += duplicate
                result = max(d[key], result)
        
        return result

if __name__ == "__main__":
    solution = Solution()
    point0 = Point(1, 1) 
    point1 = Point(1, 1) 
    point2 = Point(2, 2) 
    point3 = Point(2, 2) 
    #points = [point0, point1, point2, point3]
    points = [point0]
    #points = [point0, point1]
    print solution.maxPoints(points)
