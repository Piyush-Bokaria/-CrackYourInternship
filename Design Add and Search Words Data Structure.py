'''Day 44 of #CrackYourInternship'''
class WordDictionary:

    def __init__(self):
        self.root = set()

    def addWord(self, word: str) -> None:
        self.root.add(word)
        for i in range(len(word)):
            self.root.add(word[:i] + '.' + word[i+1:])

    def search(self, word: str) -> bool:
        if word in self.root:
            return True
        if word.count('.') !=2:
            return False
        for char in range(97,123):
            if word.replace('.', chr(char),1) in self.root:
                return True
        return False

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
