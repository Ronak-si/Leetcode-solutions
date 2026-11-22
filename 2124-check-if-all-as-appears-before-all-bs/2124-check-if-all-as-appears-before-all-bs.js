/**
 * @param {string} s
 * @return {boolean}
 */
var checkString = function(s) {

        let n=s.length;
        for(let i=0;i<n-1;i++){
            if(s.charAt(i)=='b' && s.charAt(i+1)=='a') return false;
        }
        return true;

};