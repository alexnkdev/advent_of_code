let () =
  print_endline "Hello, world!"

let x = 10
let message = "Hello"

let y = ref 5

let () =
  y := !y + 1;
  Printf.printf "%d\n" !y

(* Comment *)
let u = [1; 2; 3; 4]

let print_int_list lst = 
  List.iter (fun x -> Printf.printf "%d " x) lst;
  print_newline ()

let () = 
  print_int_list u

let () =
  Printf.printf "%d" (50 + 50);
  Printf.printf "%d" 125;
  let x = 2 * if "hello" = "world" then 3 else 5 in
    Printf.printf "x=%d\n" x

