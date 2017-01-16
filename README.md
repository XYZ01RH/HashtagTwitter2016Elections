# HashtagTwitter2016Elections
Fall 2016 VCU Social Networks &amp; Cyber Security Risks: FinalProject

Using twecoll to capture data on twitter and Gephi to graph and model the relationships

Program takes as input one .twt file at a time
.twt files are the input files collected using twecoll. Before files collect data roughly 1 week before the election. After files collect data from the days following election day

Program outputs files as .csv files (that can then be put into gephi to model the relationship)
.csv files are the output files from my program containing a sorted list of related hashtags used in tweets that also contain the queried hashtags

Queried hashtags: #election2016 #maga #imwithher

Program would parse file for anything beginning with # and convert to lowercase and give the hashtag a count of 1 if it was not found in the hashmap, and increment the count each subsequent time the hashtag was come across. It then sorted the hashmap values in descending order before outputting as a csv file.

To make the presentation fun and interested my partner and I posted each "slide" as a tweet and our classmates responded well and enjoyed our presentation. Check it out here: https://twitter.com/hashtagcmsc412
