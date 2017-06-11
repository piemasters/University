#! /usr/local/bin/perl -w
print "Welcome to the calculator.  Use it much like a normal calculator!\n";
$display=0; # initial value for display
do {
  print "Display: $display  Enter calculation (nothing to exit): ";
  $_ = <STDIN>;
  s/\s//g;   ## remove white space (NB \s includes \n, so no need to chomp)
  if (($len=length)>0) {  # we'll need the length of input later
    if ((/^[\+\-\*\/]/)) { $_=$display.$_; }
  	$evalstr='$display='.$_;
  	#  this next line executes the contents of $evalstr exactly as if this string had been written here in the program and traps any errros coming from Perl
	  if (!eval($evalstr)) { print "Oops - some problem happened\n"; }  
  }
} until ($len<=0);
print "Bye!\n";
