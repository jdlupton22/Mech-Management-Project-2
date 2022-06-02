function searchMechs() {
    // alert("Mechs are being searched")

    loadMechs();
}

async function loadMechs() {
    let url = new URL(`http://localhost:5000/mech`);

    onlyAvailable = document.getElementById('onlyAvailable');

    if (onlyAvailable.checked) {
        url.searchParams.append("onlyAvailable", true);
    }

    searchTerm = document.getElementById('searchInput').value;

    if (searchTerm) {
        url.searchParams.append("searchTerm", searchTerm);
    }

    console.log(url.toString());

    const httpResponse = await fetch(url.toString())
    const body = await httpResponse.json()

    
    console.log(body)
    
    let tableElement = document.getElementById("mechTableBody")
    tableElement.innerHTML = "";

    body.forEach(mech => {
        //Create a new tr and put it into my tbody ("table")
        let mechRow = document.createElement("tr")
        tableElement.appendChild(mechRow)

        let Data2 = document.createElement("td")
        Data2.innerHTML = mech.model
        mechRow.appendChild(Data2);
        
        let Data5 = document.createElement("td")
        Data5.innerHTML = mech.make
        mechRow.appendChild(Data5);

        let Data7 = document.createElement("td")
        Data7.innerHTML = mech.year
        mechRow.appendChild(Data7);

        let Data13 = document.createElement("td")
        Data13.innerHTML = mech.available
        mechRow.appendChild(Data13);

        let infoLink = document.createElement("td")
        infoLink.innerHTML = `<a href="mech_info.html?mechId=${mech.id}" class="btn btn-primary">View Mech</a>`
        mechRow.appendChild(infoLink)
        
      
        
    });
}