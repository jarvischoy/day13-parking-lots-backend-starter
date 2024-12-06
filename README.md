implement the Parking Manager for me: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
Standard parking strategy
Smart parking strategy
Super Smart parking strategy


implement the following apis: get: /parkinglot, return all parking lots post: /parkinglot/park, park the car in request body to the parking lots available base on the strategy selected in request body post: /parkinglot/fetch, fetch the car in request body from the parking lots



convert the parkrequest and fetch request to dto


modify the apis and dtos so that /park request body only contains a license number and strategy.


write complete api docs for the three apis


### Prompt Response

Here are the complete API docs for the three APIs:

### Get All Parking Lots

**Endpoint:** `GET /parking-lot`

**Description:** Retrieves a list of all parking lots.

**Response:**
- **200 OK**: Returns a list of parking lots.
  ```json
  [
    {
      "id": 1,
      "name": "The Plaza Park",
      "capacity": 9,
      "availableCapacity": 5
    },
    {
      "id": 2,
      "name": "City Mall Garage",
      "capacity": 12,
      "availableCapacity": 8
    },
    {
      "id": 3,
      "name": "Office Tower Parking",
      "capacity": 9,
      "availableCapacity": 7
    }
  ]
  ```

### Park a Car

**Endpoint:** `POST /parking-lot/park`

**Description:** Parks a car in one of the parking lots based on the selected strategy.

**Request Body:**
- **Content-Type:** `application/json`
- **Body:**
  ```json
  {
    "plateNumber": "ABC123",
    "strategyIndex": 0
  }
  ```

**Response:**
- **200 OK**: Returns a ticket for the parked car.
  ```json
  {
    "plateNumber": "ABC123",
    "position": 1,
    "parkingLot": 1
  }
  ```
- **400 Bad Request**: If the parking lot is full or the request is invalid.
  ```json
  {
    "error": "No available position"
  }
  ```

### Fetch a Car

**Endpoint:** `POST /parking-lot/fetch`

**Description:** Fetches a car from one of the parking lots using the provided ticket information.

**Request Body:**
- **Content-Type:** `application/json`
- **Body:**
  ```json
  {
    "plateNumber": "ABC123",
    "position": 1,
    "parkingLot": 1
  }
  ```

**Response:**
- **200 OK**: Returns the fetched car.
  ```json
  {
    "plateNumber": "ABC123"
  }
  ```
- **400 Bad Request**: If the ticket is unrecognized or the request is invalid.
  ```json
  {
    "error": "Unrecognized ticket"
  }
  ```