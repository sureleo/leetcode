class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
        result = []
        curr_line = []
        curr_length = 0
        curr = ""
        for i in xrange(len(words)):
            if len(curr_line) == 0 or (curr_length + len(words[i]) + 1) <= L:
                curr_line.append(words[i])
                curr_length += len(words[i])
                if len(curr_line) != 1:
                    curr_length += 1
            else:
                if (len(curr_line) == 1):
                    curr += curr_line[0] + ((L - len(curr_line[0])) * " ")
                else:
                    total_space = L - curr_length
                    per_space = total_space / (len(curr_line) - 1)
                    mod_space = total_space % (len(curr_line) - 1)
                    for j in xrange(len(curr_line)):
                        curr += curr_line[j]
                        if j != len(curr_line) - 1:
                            curr += (per_space + 1) * " ";
                        if mod_space != 0:
                            curr += " "
                            mod_space -= 1
                result.append(curr)
                curr = ""
                curr_line = [words[i]]
                curr_length = len(words[i])

        last_line = ""
        for i in xrange(len(curr_line)):
            if i != 0:
                last_line += " "
            last_line += curr_line[i]

        result.append(last_line + (L - len(last_line)) * " ")

        return result

if __name__ == "__main__":
    solution = Solution()

    print solution.fullJustify(["What", "be"], 12)
