# Introduction
Gemfire is a scalable and robust in-memory data grid. The Gemfire process is distributed across multiple members and can be suseptable to network and JVM issues on one or more of the indivual members. When trouble shooting such issues artifacts from each Gemfire process should be reviewed. This tool assists in quickly gathering such information.

# Gemfire Log Files
Each Gemfire member log information pertaining to:
- startup
- logging management
- connection and system membership
- distribution
- cache
- regions
- entry management
The amount of data in the log depends on the logging level set when each Gemfire process is started. For more information on logging, please check out this link:
http://gemfire.docs.pivotal.io/latest/userguide/index.html#managing/logging/logging_categories.html

# Function of this application
The log files can be very verbose. Also, depending on the size of the cluster, there could be many of them to review. This tool reads the files and pulls out all the messages of "concern", putting them into a summary Excel document.


# Usage

# Sample Output

# Questions and Support
For questions or comments please email:
lshannon@pivotal.io


