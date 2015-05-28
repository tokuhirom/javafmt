#!/usr/bin/env perl
use strict;
use warnings;
use utf8;
use 5.010000;
use File::Spec::Functions qw/rel2abs/;

eclipsefmt(@ARGV);
exit 0;

sub eclipsefmt {
    my @files = @_;

    my $eclipse = find_eclipse();
    system($eclipse,
        '-application', 'org.eclipse.jdt.core.JavaCodeFormatter',
        '-config', rel2abs('src/test/resources/org.eclipse.jdt.core.prefs'),
        (map { rel2abs($_) } glob("src/test/resources/src/*.java")),
    );
}

sub find_eclipse {
    return $ENV{ECLIPSE} if $ENV{ECLIPSE};
    my ($eclipse) = sort glob('/opt/homebrew-cask/Caskroom/eclipse-ide/*/eclipse/eclipse');
    return $eclipse;
}

