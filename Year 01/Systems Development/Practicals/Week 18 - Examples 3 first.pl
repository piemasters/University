#! /usr/local/bin/perl -w
print "Welcome to the calculator.  Use it much like a normal calculator!\n";
$display=0; # initial value for display
do {
  print "Display: $display  Enter calculation (nothing to exit): ";
  $_ = <STDIN>;
  s/\s//g;   ## remove white space (NB \s includes \n, so no need to chomp)
  if (($len=length)>0) {  # we'll need the length of input later
    ($sign1,$num1,$op,$sign2,$num2) = /([\+\-]?)(\d*\.?\d*)([\+\-\*\/]?)([\+\-]?)(\d*\.?\d*)/; 
  	# handle '*n' or '*-n' type entries
	  if (length($num1)==0) { $sign1='+'; $num1=$display; }
	  # handle '+n' type entry
      if ($op !~ /[\+\-\*\/]/) { $op=$sign1; $num2=$num1; $sign1='+'; $num1=$display; }
      if ($sign1 !~ /[\+\-]/) { $sign1='+1'; } else {	$sign1.='1'; }
      if ($sign2 !~ /[\+\-]/) { $sign2='+1'; } else {	$sign2.='1'; }
    	$evalstr='$display=('.$sign1.'*'.$num1.')'.$op.'('.$sign2.'*'.$num2.')';
	    #  this next line executes the contents of $evalstr exactly as if this string had been written here in the program and traps any errros coming from Perl
    	if (!eval $evalstr) { print "Oops - some problem happened\n"; }  
  }
} until ($len<=0);
print "Bye!\n";
