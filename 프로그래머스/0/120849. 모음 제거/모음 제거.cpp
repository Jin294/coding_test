#include <string>
#include <regex>

using namespace std;

string solution(string my_string) {
    my_string = regex_replace(my_string, regex("a"), "");
    my_string = regex_replace(my_string, regex("e"), "");
    my_string = regex_replace(my_string, regex("i"), "");
    my_string = regex_replace(my_string, regex("o"), "");
    my_string = regex_replace(my_string, regex("u"), "");
    
    return my_string;
}