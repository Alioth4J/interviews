-- KEYS[1]: lock key
-- ARGV[1]: client id
-- ARGV[2]: expire time

if (redis.call('EXISTS', KEYS[1]) == 0) or (redis.call('HEXISTS', KEYS[1], ARGV[1]) == 1) then
    local count = redis.call('HINCRBY', KEYS[1], ARGV[1], 1)
    redis.call('PEXPIRE', KEYS[1], ARGV[2])
    return count
end

return 0
