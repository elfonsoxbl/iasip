package com.elfonso.iasipchooser.codes

/*CodeTracker for tracking the entry and usage of the codes used in this program.*/
class CodeTracker (private var codeList: Collection<HiddenCode>) {
    private var codeEntry = ""
    private var maxCodeLength = 0

    init {
        // Initialize the code list.
        for (code in this.codeList) {
            if (this.maxCodeLength < code.length) {
                this.maxCodeLength = code.length
            }
        }
    }

    fun enterCode(codeNumberString : String) : Int {
        this.codeEntry += codeNumberString
        for ((index, code) in this.codeList.withIndex()) {
            if (code.matchesEntry(this.codeEntry)) {
                this.resetCodeEntry()
                return index
            }
        }
        if (this.codeEntry.length == this.maxCodeLength) {
            resetCodeEntry()
        }
        return -1
    }

    fun getHiddenCode(codeIndex : Int) : HiddenCode {
        return this.codeList.elementAt(codeIndex)
    }

    fun resetCodeEntry() {
        this.codeEntry = ""
    }

    fun getCode() : String {
        return this.codeEntry
    }
}
