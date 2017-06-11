//############# RECEIVER ###############

//______________________________________
//              C Program      
//______________________________________

//============= Declarations ===========

#include <stdio.h>								// Library for basic commands
#include <conio.h>								// Library to create a text user interface in DOS
#define EOT 0x40								// Defines End of Transmission character (@)

//======================================

int main(void) {

//============= Declarations ===========

char wtmode[] = "wb";							// Parameter for write
char rdmode[] = "rb";							// Parameter for read
char fname[] = "W:\\RFile.txt";					// File locatiion
char pname[] = "COM2";							// Name sending computer
char error1[] = "data file failed to open\n";	// Error message
char error2[] = "com port failed to open\n";	// Error message

FILE * fileptr;									// Handles COM port
FILE * portptr;									// Handles COM port

//======================================

//______________________________________
//              ASM Program      
//______________________________________

//=========== Data File ================

//-------Load Data File to Write--------

__asm { loadDatFile:
		lea		eax,wtmode						// Parameters onto stack
		push	eax								// Move to stack
		lea		eax,fname						// Load data file onto eax
		push	eax								// Move to stack
		call	DWORD PTR (fopen)				// Open data file for reading
		add		esp,8							// Scrub parameters off stack
		or		eax,eax							// Check file opened OK
		jnz		loadComPort						// Skip to loadComPort
}

//--------------------------------------

//--------Error with Data File----------

__asm { dataFileError:
		lea		eax,error1						// Move error message to eax
		push	eax								// Move to stack
		call	DWORD PTR printf				// Fail to open file											//;fail to open file
		add		esp, 4							// Scrub stack pointer off stack
		jmp		endit							// Abort program
}

//--------------------------------------

//======================================


//============ COM Port ================

//------------Load COM Port-------------

__asm { loadComPort:										

		mov		DWORD PTR (fileptr),eax			// Save file handle
		lea		eax,rdmode						// Parameters onto stack
		push	eax								// Move to stack
		lea		eax,pname						// COM name onto stack
		push	eax								// Move to stack
		call	DWORD PTR (fopen)				// Open COM port for writing
		add		esp,8							// Scrub parameters off stack
		or		eax,eax							// Set Z flag if eax is 0
		jnz		portOK							// Skip to portOK
}

//--------------------------------------

//--------Error with Data File----------

__asm { comError:
		lea		eax, error2						// Move error message to eax
		push	eax								// Move to stack
		call	DWORD PTR (printf)				// Fail to open port
		add		esp, 4							// Scrub stack pointer off stack
		mov		eax, DWORD PTR (fileptr)		// Clear file handle
		push	eax								// Move to stack
		call	DWORD PTR (fclose)				// Close data file from reading
		add		esp,4							// Scrub stack pointer off stack
		jmp		endit							// Abort program
}
//--------------------------------------

//======================================

__asm {	portOK:

		mov		DWORD PTR (portptr),eax			// Save port handle
}

//========== Transmit Data =============

//-------------Get Letter---------------

__asm { getLetter:

		mov		eax, DWORD PTR (portptr)		// Copy char on port to eax
		push	eax								// Move to stack
		call	DWORD PTR (fgetc)				// Get next char from data file
}

//--------------------------------------

//------------Decrypt Letter------------

__asm { decryptLetter:

		xor		al, 'b'							// Xor CHAR against binary value of b
		rol		al, 4							// Move ASCII value four to the left
		ror		al, 2							// Move ASCII value two to the right
}

//--------------------------------------

//-----Check For End Of Transmission----

__asm { endOfTransmission:
		add		esp,4							// Scrub stack pointer off stack
		cmp		eax, EOT						// Check for end of data
		jz		lastChar						// Skip to lastChar if no more data
}

//--------------------------------------

//--------Write Character & Loop--------

__asm { writeChar:
		mov		ebx,eax							// Load ebx with the value in eax
		mov		eax, DWORD PTR  (fileptr)		// Clear file handle
		push	eax								// Move to stack
		push	ebx								// Move to stack
		call	DWORD PTR (fputc)				// Write char to file
		add		esp,8							// Scrub stack pointer off stack
		jmp		getLetter						// Loop back to getLetter
}

//--------------------------------------

//-------------End Of File--------------
//--------Receive Last Character--------

__asm { lastChar:
		
		mov		eax, DWORD PTR (fileptr)		// Clear file handle
		push	eax								// End of data so
		mov		eax,EOT							// Send terminating sentinal
		push	eax								// Move to stack
		call	DWORD PTR (fputc)				// Get last char from data file
		add		esp, 8							// Scrub stack pointer off stack
}

//--------------------------------------

//------------Close Receiver------------

__asm { closeReceiver:
		mov		eax, DWORD PTR (fileptr)		// Clear file handle
		push	eax								// Move to stack
		call	DWORD PTR (fclose)				// Close data file
		add		esp,4							// Scrub stack pointer off stack

		mov		eax, DWORD PTR (portptr)		// Clear port handle
		push	eax								// Move to stack
		call	DWORD PTR (fclose)				// Flush and close COM port
		add		esp,4							// Scrub stack pointer off stack

endit:
}

//--------------------------------------

return 0;										// Close program
}												// End of C