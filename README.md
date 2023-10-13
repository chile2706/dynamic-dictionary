# Dynamic Dictionary
This is a user-friendly Slang Dictionary program. 
## I. Populate Dictionary
- Populate the dictionary by prompting the user for the name(s) of a file
- Read in the definitions and store them in the dictionary.
- Once the user finishes populating, the program sorts the dictionary into lexically ascending order.
## II. Interact with the Dictionary
### Search
- Search will look for the definition of a word or phrase and print out the word(s) or phrase(s) and its(their) definition(s).
- If there is more than one partial case-insensitive match, the program will print out all the words or phrases matching some or all of the search word or phrase.
- **At a minimum, the word or phrase entered by the user must contain the first letter of the first word of a word or phrase already present in the dictionary.**
### Delete
After obtaining the word or phrase the user is trying to delete
  - If there is an exact match, the program remove the word or phrase and its definition
  - If there is more than one partial case-insensitive match, the program will report that there was more than one possible candidate for removal, and print out all the words or phrases matching some or all of the search word or phrase and their respective definitions.

### Add
After obtaining the word or phrase and new definition from the user, 
  - The program will check to see if an exact case-insensitive match already exists in the dictionary. If there is, the program will report that the word or phrase already exists to the user
  - Otherwise, the program will add the new word or phrase to the dictionary
### Update
- After obtaining the word or phrase and new definition from the user, the program will find the exact match for the word or phrase and replace the existing definition with the new definition
- If an exact (case insensitive) match does not exist, then the program will report that
## III. Close
Close the dictionary
- Prompt the user for the name of an output file
- Write the current contents of the dictionary (sorted in lexically ascending order, A→Z) out to the file
## UML Diagram
![UML](UML.png)
