package hphuc5453.custom_library

import android.content.res.Resources
import hphuc5453.custom_library.Contants.Companion.EMOJI_HASH_SET

class Utils {

    companion object{
        fun milliSecondsToTimer(milliseconds: Long): String? {
            var finalTimerString = ""
            var secondsString = ""
            // Convert total duration into time
            val hours = (milliseconds / (1000 * 60 * 60)).toInt()
            val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
            val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()
            // Add hours if there
            if (hours > 0) {
                finalTimerString = "$hours:"
            }
            // Prepending 0 to seconds if it is one digit
            secondsString = if (seconds < 10) {
                "0$seconds"
            } else {
                "" + seconds
            }
            finalTimerString = "$finalTimerString$minutes:$secondsString"
            // return timer string
            return finalTimerString
        }

        private fun toHexStr(c: Int): String? {
            return Integer.toHexString(c)
        }

        @JvmStatic
        fun containsEmoji(str: String): Boolean {
            // unicode can be at most 2 Java Char(utf-16), use code point
            val i = str.offsetByCodePoints(0, 0)
            val codePoint = str.codePointAt(i)
            if (EMOJI_HASH_SET.contains(toHexStr(codePoint))) {
                return true
            }
            return false
        }

        @JvmStatic
        fun getEmoji(str: String): String? {
            val sb = StringBuilder()
            // unicode can be at most 2 Java Char(utf-16), use code point
            // i is index by code point
            val i = str.offsetByCodePoints(0, 0)
            val codepoint = str.codePointAt(i)
            if (EMOJI_HASH_SET.contains(toHexStr(codepoint))) {
                // code point back to char
                sb.append(Character.toChars(codepoint))
            }
            return sb.toString()
        }

        @JvmStatic
        fun convertDpToPx(dpInput: Float) : Float {
            return (dpInput * Resources.getSystem().displayMetrics.density)
        }
    }

}