-- KEYS[1]: lock key
-- ARGV[1]: client id

if (redis.call('EXISTS', KEYS[1]) == 0) or (redis.call('HEXISTS', KEYS[1], ARGV[1]) == 0) then
    return -1
end

local count = redis.call('HINCRBY', KEYS[1], ARGV[1], -1)
if count == 0 then
    redis.call('DEL', KEYS[1])
end

return count
