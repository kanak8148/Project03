 document.addEventListener("DOMContentLoaded", function () {

        // Selecting the start, stop, and speak buttons
        const startBtn = document.querySelector("#start");
        const stopBtn = document.querySelector("#stop");
        const speakBtn = document.querySelector("#speak");

        // Initializing the SpeechRecognition API
        const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
        const recognition = new SpeechRecognition();

        recognition.continuous = true;  // Continuously listen until you
										// manually stop
        recognition.interimResults = false;  // Only get the final result
        recognition.lang = "en-US";
       // recognition.lang = 'hi-IN';
        // You can change this to "hi-IN" for Hindi or other languages

        recognition.onstart = function () {
            console.log("Voice recognition activated. You can speak into the microphone.");
        };

        recognition.onend = function () {
            console.log("Voice recognition has stopped.");
        };

        // Capture speech result
        recognition.onresult = function (event) {
            const current = event.resultIndex;
            const transcript = event.results[current][0].transcript.toLowerCase();  // Normalize
																					// to
																					// lowercase
            console.log("You said: ", transcript);  // Print out what you said

            // Example: Respond based on the transcript
            if (transcript.includes("open whatsapp")) {
                readOut("Opening WhatsApp for you.");
                window.open("https://web.whatsapp.com", "_blank");
            }else if (transcript.includes("open google")) {
                readOut("Opening Google for you.");
                window.open("https://myaccount.google.com", "_blank");
            }else if (transcript.includes("open welcome")) {
                readOut("open welcome page for you");
                window.open("http://localhost:8080/project_3/WelcomeCtl", "_blank");
            }else if (transcript.includes("open add user")) {
                readOut("please add the user");
                window.open("http://localhost:8080/project_3/ctl/UserCtl", "_blank");
            }else if (transcript.includes("open user list")) {
                readOut("open list for you");
                window.open("http://localhost:8080/project_3/ctl/UserListCtl", "_blank");
            }else if (transcript.includes("open javadoc")) {
                readOut("Read the javadoc");
                window.open("http://localhost:8080/project_3/doc/index.html", "_blank");
            }else if (transcript.includes("open my profile")) {
                readOut("open your profile");
                window.open("http://localhost:8080/project_3/ctl/MyProfileCtl", "_blank");
            }else if (transcript.includes("hello")) {
                readOut("Hello! How can I assist you?");
            }else if (transcript.includes("oyeeeee")) {
                    readOut("hann sun rha huu reee");
            }else if (transcript.includes("how are you")) {
                readOut("I'am fine, thank you!");
            }else if (transcript.includes("i love you")) {
                readOut("I love you too!");
            }else if (transcript.includes("kya app meri madad kr skte hey")) {
                readOut("hann kahiye me apki kya madad kr skti hu");
            }else if (transcript.includes("yes bro always for you")) {
                readOut("Nothing special.");
            }else {
                readOut("You said: " + transcript);  // Speak out what you
														// said
            }
        };

        // Start listening when you press the start button
        startBtn.addEventListener("click", () => {
            recognition.start();  // Start voice recognition
        });

        // Stop listening when you press the stop button
        stopBtn.addEventListener("click", () => {
            recognition.stop();  // Stop voice recognition
        });

        // Function to read out a message
        function readOut(message) {
            const speech = new SpeechSynthesisUtterance();
            const voices = speechSynthesis.getVoices();

            // Choose a default voice if index 36 is not available
            speech.voice = voices[36] || voices[0];
            speech.text = message;
            speech.volume = 1;

            window.speechSynthesis.speak(speech);
            console.log("Speaking out:", message);
        }

        // Speak a default message when you press the speak button
        speakBtn.addEventListener("click", () => {
            readOut("Hello, I'm your assistant.");
        });

        // Optionally speak a message when the page loads
        window.onload = function () {
            readOut("Ready to assist you.");
        };

    });