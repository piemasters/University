#! /usr/local/bin/perl -w

###########  EXAMPLE 1  ###########

$in="Fred Bloggs,01-02-78,BS16 1QY";

## TRADITIONAL CODE 

$x1=index($in,' ');
$forename=substr($in,0,$x1-1);
$x2=index($in,',',$x1);
$lastname=substr($in,$x1+1,($x2-1)-$x1);
$x1=$x2; $x2=index($in,'-',$x1);
$day=substr($in,$x1+1,($x2-1)-$x1);
$x1=$x2; $x2=index($in,'-',$x1);
$month=substr($in,$x1+1,($x2-1)-$x1);
$x1=$x2; $x2=index($in,',',$x1);
$year=substr($in,$x1+1,($x2-1)-$x1);
$x1=$x2; $x2=index($in,' ',$x1);
$postcode_left=substr($in,$x1+1,($x2-1)-$x1);
$x1=$x2; $x2=length($in);
$postcode_right=substr($in,$x1+1,($x2-2)-$x1);

## REGULAR EXPRESSION_BASED CODE

$_=$in;
($firstname,$lastname,$day,$month,$year,$postcode_left,$postcode_right) = /(.*) (.*),(.*)-(.*)-(.*),(.*) (.*)/;
 
print "$firstname $lastname,$day-$month-$year,$postcode_left $postcode_right\n";
 
$in="Fred Bloggs,01-02-78,B19A 1QY";

$_=$in;
if (($firstname,$lastname,$day,$month,$year,$postcode_left,$postcode_right) = 
         /(.*) (.*),(\d\d)-(\d\d)-(\d\d),([A-Za-z]{1,2}\d{1,2}[A-Za-z]{0,1}) (\d[A-Za-z][A-Za-z])/) {
  print "$firstname $lastname,$day-$month-$year,$postcode_left $postcode_right\n";
}
else {
  print "Something wrong with input";
}

###########  EXAMPLE 2  ###########

$in="pupils are part of the eye and pupils are also scholars (pupilpupil)";

## TRADITIONAL CODE 

while (($x=index($in,'pupil'))>=0) {
  $in2=substr($in,0,$x).'student'.substr($in,$x+5);
  $in=$in2;  
}
print "$in\n";

## REGULAR EXPRESSION_BASED CODE

$in="pupils are part of the eye and pupils are also scholars (pupilpupil)";

$in =~ s/pupil/student/g;
print "$in\n";

#  preserving initial letter case

$in="pupils are part of the eye and pupils are also scholars (pupilpupil)";

$in =~ s/pupil/student/g;
$in =~ s/Pupil/Student/g;
print "$in\n";
