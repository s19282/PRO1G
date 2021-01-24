import java.time.LocalDate
import java.time.format.DateTimeParseException

def text = "Lorem ipsum dolor sit amet, 2020-15-11consectetur adipiscing elit. " +
        "Suspendisse vel commodo magna. Morbi euismod sapien in tellus tincidunt, " +
        "at fermentum orci laoreet. Suspendisse 2010-30-12auctor sapien et enim faucibus lobortis." +
        " Curabitur eu lacinia dui. Duis at nisl vel ligula bibendum 2013-11-50interdum sed non sem. " +
        "Nullam malesuada tellus in ex elementum,2008-03-07 ut gravida arcu porttitor. " +
        "Phasellus tortor est, 2020-11-28ullamcorper tincidunt consectetur ac, imperdiet eget ex. "

def regex = "\\d{4}-\\d{2}-\\d{2}"

def matcher = text=~ regex

matcher.each {try{println LocalDate.parse(it.toString())}catch(DateTimeParseException ignored){}}
