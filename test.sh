# Run

get(){ 
    curl -X GET localhost:5555 2> /dev/null
}

./jdk/bin/java -cp bin/ main.Main &
PID=$!
echo "Java PID=$PID"

get

while [ $? -ne 0 ]
do
    sleep 0.2
    get
done
sleep 0.2
get
sleep 0.2
get
sleep 0.2

kill $PID;
echo Ok!
