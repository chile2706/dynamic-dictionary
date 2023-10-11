# Dynamic Dictionary
This is a user-friendly Slang Dictionary program. 
## I. Populate Dictionary
- Populate the dictionary by prompting the user for the name(s) of a file containing dictionary definitions
- Read in the definitions and store them in the dictionary.
- If there is a collision between a word already in the dictionary and the same word is present in the new dictionary file, the existing definition present in the dictionary should be updated to the new definition.
- If there is an error opening or reading the input file, your program should report the error and re-prompt the user for another dictionary file
- Once the user indicates that they have no more files to enter, your program should sort the dictionary into lexically ascending order.
## II. Interact with the Dictionary
### Search
- Search will look for the definition of a word or phrase in the dictionary and print out the word(s) or phrase(s) and its(their) definition(s).
- if there is more than one partial case-insensitive match, your program should print out all the words or phrases matching some or all of the search word or phrase.
- **At a minimum, the word or phrase entered by the user must contain the first letter of the first word of a word or phrase already present in the dictionary.**
### Delete
- After obtaining the word or phrase the user is trying to delete
  - If there is an exact match, your program should remove the word or phrase and its definition, and report that the word or phrase was successfully removed from the dictionary to the user.
  - if there is more than one partial case-insensitive match for the word or phrase the user is trying to remove, your program should report that there was more than one possible candidate for removal, and print out all the words or phrases matching some or all of the search word or phrase and their respective definitions.

### Add
- After obtaining the word or phrase and new definition from the user, 
  - your program should check to see if an exact case-insensitive match for the new word or phrase already exists in the dictionary. If there is, your program should report that the word or phrase already exists to the user and prompt them for their next command. 
  - Otherwise, your program should the new word or phrase to the dictionary, report success to the user, and prompt them for their next command.
### Update
- After obtaining the word or phrase and new definition from the user, your program should find the exact match for the word or phrase
 in the dictionary and then replace the existing definition with the new definition, report success and then prompt the user for their next command. 
- If an exact (case insensitive) match for the does not exist, then your program should report that and prompt the user for the next command.
## III. Close
Close the dictionary
- Prompt the user for the name of an output file,
- write the current contents of the dictionary (sorted in lexically ascending order, A→Z) out to the file
## UML Diagram
![UML](UML.png)
