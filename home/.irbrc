# Some default enhancements/settings for IRB, based on
# http://wiki.rubygarden.org/Ruby/page/show/Irb/TipsAndTricks
unless defined? HOME_IRBRC_LOADED
  # Require RubyGems by default.
  require 'rubygems'
  
  # Activate auto-completion.
  require 'irb/completion'
  
  # Use the simple prompt if possible.
  IRB.conf[:PROMPT_MODE] = :SIMPLE if IRB.conf[:PROMPT_MODE] == :DEFAULT
  
  # Setup permanent history.
  HISTFILE = "~/.irb_history"
  MAXHISTSIZE = 100
  begin
    histfile = File::expand_path(HISTFILE)
    if File::exists?(histfile)
      lines = IO::readlines(histfile).collect { |line| line.chomp }
      puts "Read #{lines.nitems} saved history commands from '#{histfile}'." if $VERBOSE
      Readline::HISTORY.push(*lines)
    else
      puts "History file '#{histfile}' was empty or non-existant." if $VERBOSE
    end
    Kernel::at_exit do
      lines = Readline::HISTORY.to_a.reverse.uniq.reverse
      lines = lines[-MAXHISTSIZE, MAXHISTSIZE] if lines.size > MAXHISTSIZE
      puts "Saving #{lines.length} history lines to '#{histfile}'." if $VERBOSE
      File::open(histfile, File::WRONLY|File::CREAT|File::TRUNC) { |io| io.puts lines.join("\n") }
    end
  rescue => e
    puts "Error when configuring permanent history: #{e}" if $VERBOSE
  end
  
  require "tempfile"
  
  def ministat(a, *b)
    files = []
    for x in ([a] + b).select { |x| !x.empty? }
      tf = Tempfile.new("irb-ministat")
      for y in x
        tf.puts y
      end
      tf.flush
      files << tf
    end
    
    result = `ministat #{files.map { |f| f.path }.join(" ")}`
    puts result
  ensure
    files.each { |f| f.close! }
  end
  
  HOME_IRBRC_LOADED=true
end
